package com.ncic.fileProcess;

import com.ncic.config.ManagerProperties;
import com.ncic.pattern.MixConvert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileHandler {
    private List<String> fileStrs = new ArrayList<>();

    public void convertHIP(String configKey){
        String rootPathStr = ManagerProperties.getConfigProperty(configKey);
        File rootFile = new File(rootPathStr);
        addAllFile(rootFile);
        //TODO 修改为多线程执行

        for(String path:fileStrs){
            //TODO  HIP -> CUDA
            File f = new File(path);
            try {
                String oldName = f.getName();
                System.out.println("----------------"+oldName+"------------------");
                /**
                 * jdk 1.7
                 */
//                FileReader fr = new FileReader(f);
//                BufferedReader br = new BufferedReader(fr);
//                String line;
//                while((line = br.readLine()) != null)
//                    System.out.println(line);
                /**
                 * jdk 1.8
                 */
                Stream<String> lines = Files.lines(Paths.get(f.getPath()));
                String res = lines.map(MixConvert::convertText)
                     .reduce("",(x,y)->x+y);
                byte [] buf = res.getBytes();
                String newName = oldName.replace(".cpp",".cu");
                System.out.println("----------------"+newName+"------------------");
                String targetPath = path.replace(oldName,newName);
                Files.write(Paths.get(targetPath),buf);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public void addAllFile(File f){
        File[] files = f.listFiles();
        for(File file:files){
            System.out.println(file);
            if(file.isDirectory())
                addAllFile(file);
            else{
                if(file.getPath().endsWith(".cpp"))
                    this.fileStrs.add(file.getPath());
            }
        }
    }
}
