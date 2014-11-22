package us.awpwo;

import java.io.File;
import java.util.Scanner;

import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class Main {

	@Option(name = "--filename")
    private String filename = "test.dat";
	
	public static void main(String[] args) {
		try {
			new Main().run(args);
		}
		catch (Exception e) {
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
		}
	}
	
	public void run(String[] args) throws Exception {
		CmdLineParser parser = new CmdLineParser(this);
        parser.setUsageWidth(80);
        parser.parseArgument(args);
        File file = new File(System.getProperty("user.dir") + "/data/" + filename);
        Scanner scanner = new Scanner(file);
        int N = scanner.nextInt(), i, p, q;
		UF uf = new UF(N);
		System.out.println(N);
		for (i = 0; i < N; ++i) {
			p = scanner.nextInt();
			q = scanner.nextInt();
			if (! uf.connected(p, q)) {
				uf.union(p, q);
				System.out.println(p + " + " + q);
			}
		}
		N = scanner.nextInt();
		System.out.println(N);
		for (i = 0; i < N; ++i) {
			p = scanner.nextInt();
			q = scanner.nextInt();
			System.out.println(p + " - " + q + ": " + uf.connected(p, q));
		}
		scanner.close();
	}

}