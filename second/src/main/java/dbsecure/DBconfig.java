package dbsecure;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@Configuration  //내가 설정 클래스 입니다
@EnableEncryptableProperties   //
public class DBconfig {
	@Bean("jasyptEncryptor")  //메소드 리턴 객체 주입
	public StringEncryptor stringEncryptor(){
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(System.getenv("DB_PASSWORD"));
        config.setAlgorithm("PBEWithMD5AndDES"); // 알고리즘
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        System.out.println("=== DBConfig 출력");
        System.out.println(System.getenv("DB_PASSWORD"));
        System.out.println(encryptor.decrypt("E4oHL/xQ3/k8MV0WHBxcK66nbxHsCJszllWPMFVHmKY="));
        System.out.println(encryptor.decrypt("dWjTXDLrGyiIR+BDhRJcAL2eqOU5EHrsg8m/3LHgNLhOTV9fHgc9+twf1BvBzOmE8B0XjYFkAGSqDxGIyfBsSQerzMH7iqbvjL5Yv5X/1Gjk5NfHEpoccqiv73DbBlp4zHBWmg1/h6E="));
        System.out.println(encryptor.decrypt("xiZBJ9zfCkt7WBU0FUCI7lpxACb3QwLb"));
        System.out.println(encryptor.decrypt("dJqKDyEPWOHTx0cdpFJm+w3rEh6Naikf"));
        /*
        #ENC(E4oHL/xQ3/k8MV0WHBxcK66nbxHsCJszllWPMFVHmKY=)
        #ENC(dWjTXDLrGyiIR+BDhRJcAL2eqOU5EHrsg8m/3LHgNLhOTV9fHgc9+twf1BvBzOmE8B0XjYFkAGSqDxGIyfBsSQerzMH7iqbvjL5Yv5X/1Gjk5NfHEpoccqiv73DbBlp4zHBWmg1/h6E=)
        #ENC(xiZBJ9zfCkt7WBU0FUCI7lpxACb3QwLb)
        #ENC(dJqKDyEPWOHTx0cdpFJm+w3rEh6Naikf)
        암호화된 파일명*/
        
        return encryptor;
	}
}
