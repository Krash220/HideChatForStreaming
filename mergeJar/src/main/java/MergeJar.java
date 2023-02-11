import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MergeJar {

    public static void main(String[] args) throws Exception {
        File outputDir = new File("dists");

        outputDir.mkdir();

        File output = new File(outputDir, "${MOD_NAME}-${MOD_VERSION}.jar");
        JarOutputStream stream = new JarOutputStream(new FileOutputStream(output));

        for (int i = 0; i < args.length; i++) {
            File jar = new File(new File(args[i]), "build/libs/output.jar");

            if (jar.exists()) {
                System.out.println(jar.getAbsolutePath());
                writeJar(stream, new JarFile(jar), true);
            }
        }

        File jar = new File("build/libs/output.jar");

        if (jar.exists()) {
            System.out.println(jar.getAbsolutePath());
            writeJar(stream, new JarFile(jar), false);
        }

        stream.close();
    }

    private static void writeJar(JarOutputStream out, JarFile in, boolean skipManifest) throws Exception {
        Enumeration<JarEntry> e = in.entries();

        while (e.hasMoreElements()) {
            JarEntry entry = e.nextElement();

            if (entry.isDirectory()) {
                continue;
            }

            if (entry.getName().equals("META-INF/MANIFEST.MF") && skipManifest) {
                continue;
            }

            if (entry.getName().equals("output-refmap.json")) {
                continue;
            }

            InputStream stream = in.getInputStream(entry);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            byte[] b = new byte[4096];

            while (true) {
                int i = stream.read(b);
                if (i <= 0)
                    break;
                bos.write(b, 0, i);
            }

            if (entry.getName().endsWith("mixins.json")) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                Map map = gson.fromJson(bos.toString("UTF-8"), Map.class);

                map.remove("refmap");

                String json = gson.toJson(map);

                bos.reset();
                bos.write(json.getBytes("UTF-8"));
            }
            
            System.out.println(" + " + entry.getName());

            entry = new JarEntry(entry.getName());

            out.putNextEntry(entry);
            out.write(bos.toByteArray());
        }

        in.close();
    }
}
