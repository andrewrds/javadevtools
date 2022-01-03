package com.javadevtools.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Component;

@Component
public class HashGeneratorService {
	private static final String[] algorithms = { "MD5", "SHA1", "SHA-256", "SHA-512" };

	public Map<String, Object> generate(HashGenerateParams params) {
		Map<String, Object> result = new HashMap<>();

		for (String algorithm : algorithms) {
			try {
				byte[] bytes = params.getText().getBytes(StandardCharsets.UTF_8);
				MessageDigest md = MessageDigest.getInstance(algorithm);
				byte[] hash = md.digest(bytes);
				String hashString = Hex.encodeHexString(hash);
				result.put(algorithm.replace('-', '_'), hashString);
			} catch (NoSuchAlgorithmException e) {
				result.put(algorithm, "Unsupported");
			}
		}

		return result;
	}
}
