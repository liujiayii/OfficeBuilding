package com.yqwl.controller;

import java.util.UUID;

import com.yqwl.common.utils.UpdateFiles;

public class Test {
	public static void main(String[] args) {
		String uuid = "https://system-im.oss-cn-beijing.aliyuncs.com/shop/57A4F67F1D73472E9BB8FE524672DF89.png?Expires=1558657754&OSSAccessKeyId=LTAIvnDBZYK3DLbL&Signature=9GYGGDntxGwhIU44fWPBuzehKVY%3D";
		try {
			UpdateFiles.deleatFile(uuid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
