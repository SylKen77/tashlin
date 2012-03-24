package be.optis.tashlin.core.build;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MavenBuildStrategy implements BuildStrategy {

	private static final long serialVersionUID = 5677732699204575968L;

	public void build() {
		try {
			
			
			String mavenHome = "D:/DEV/maven/bin";
			String cmd = mavenHome + "/mvn.bat -f \"D:/Profiles/avdheuve/.jenkins/jobs/spring-test/workspace/pom.xml\" clean install";
			Process pr = Runtime.getRuntime().exec(cmd);
			BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			String line = "";
			while ((line=buf.readLine())!=null) {
				System.out.println(line);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} 
	}

}
