package com.holy.sboot.origin.utils;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.netease.cloud.ClientConfiguration;
import com.netease.cloud.auth.BasicCredentials;
import com.netease.cloud.auth.Credentials;
import com.netease.cloud.services.nos.NosClient;
import com.netease.cloud.services.nos.model.Bucket;
import com.netease.cloud.services.nos.model.ObjectMetadata;
import com.netease.cloud.services.nos.model.PutObjectRequest;

/**
 * Beehive对象，用于对象存储 NOS
 * 
 * @author Holy
 * @date 2017年6月14日 下午4:31:02
 * @ref support.c.163.com/md.html#!平台服务/对象存储/SDK 手册/Java SDK 手册/Java SDK 手册 - 文件上传.md
 */
public class HiveNOS {

	private static NosClient nosClient;
	private static final String BUCKNAME = "holy";
	private static final String ENDPOINT = "nos-eastchina1.126.net";
	private static final String PREFIX = "origin/photo/";

	static {
		String accessKey = "bc87c639f52043b882f967fc35e6a831";
		String secretKey = "3fb81d642bad40a19e502e90dca6f45b";
		Credentials credentials = new BasicCredentials(accessKey, secretKey);
		ClientConfiguration conf = new ClientConfiguration();
		// 设置 NosClient 使用的最大连接数
		conf.setMaxConnections(200);
		// 设置 socket 超时时间
		conf.setSocketTimeout(10000);
		// 设置失败请求重试次数
		conf.setMaxErrorRetry(2);
		// 如果要用 https 协议，请加上下面语句
		// conf.setProtocol(Protocol.HTTPS);
		nosClient = new NosClient(credentials, conf);
		nosClient.setEndpoint(ENDPOINT);
		// transferManager = new TransferManager(nosClient);
	}

	public static List<Bucket> showBuckets() {
		// for (Bucket bucket : nosClient.listBuckets()) {
		// System.out.println("————————" + bucket.toString() + "————————");
		// }
		return nosClient.listBuckets();
	}

	/**
	 * 上传图片
	 * @param file
	 * @return NOS中的文件路径
	 */
	public static String uploadPhoto(File file) {
		return new HiveNOS().upload(file, null, null);
	}

	/**
	 * 更新图片
	 * @param file
	 * @param existingPath 数据库中已经存在的路径
	 * @return NOS中的文件路径，同库中路径
	 */
	public static String updatePhoto(File file, String existingPath) {
		// http://holy.nos-eastchina1.126.net/origin/photo/BlHSUuMjC2.jpg
		if (existingPath.lastIndexOf(ENDPOINT) != -1) {
			existingPath = existingPath.substring(existingPath.lastIndexOf(ENDPOINT) + ENDPOINT.length() + 1);
		}
		return new HiveNOS().upload(file, existingPath, null);
	}

	private String upload(File file, String dirPath, Map<String, String> userMetadata) {
		if (file == null)
			return null;

		List<String> symbol = Arrays.asList(".jpg", ".jpeg", ".png", ".gif", ".ico");
		try {
			// file = new File("C:\\Users\\ADMINIBM\\Desktop\\dd.jpg");
			String fname = file.getName();
			String suffix = fname.substring(fname.lastIndexOf(".")).toLowerCase();

			if (!symbol.contains(suffix))
				return null;

			ObjectMetadata objectMetadata = new ObjectMetadata();
			// Map<String, String> userMetadata = new HashMap<>();
			// userMetadata.put("test", "0001");
			objectMetadata.setUserMetadata(userMetadata);

			if (dirPath == null || "".equals(dirPath))
				dirPath = PREFIX + IdGen.gen() + suffix;

			PutObjectRequest objectRequest = new PutObjectRequest(BUCKNAME, dirPath, file);
			objectRequest.setMetadata(objectMetadata);
			nosClient.putObject(objectRequest);
			return "http://" + BUCKNAME + "." + ENDPOINT + "/" + dirPath;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		// Beehive.showBuckets();
		// System.out.println("——————" + nosClient.doesBucketExist("holy"));
		// nosClient.setBucketAcl("holy", CannedAccessControlList.Private);
		// System.out.println("——————" + nosClient.getBucketAcl("holy"));

		// ObjectMetadata objectMetadata2 = nosClient.getObjectMetadata(BUCKNAME, "origin/photo/BlusNWs7m8.jpg");
		// String string = objectMetadata2.getUserMetadata().get("test");
		// System.out.println(string);

		// String uploadPhoto = HiveNOS.uploadPhoto(new File(""));
		// System.out.println(uploadPhoto);

		// System.out.println("".equals(null));
		File file = new File("C:\\Users\\ADMINIBM\\Desktop\\dd.jpg");
		// System.out.println(uploadPhoto(file));
		System.out.println(HiveNOS.updatePhoto(file, "http://holy.nos-eastchina1.126.net/origin/photo/BlHSUuMjC2.jpg"));
	}
}
