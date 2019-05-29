package cn.itcast.lucene;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

/**
 * 创建索引
 */
public class CreateIndex {

    @Test
    public void createIndex() throws IOException {
        //1.通过FSDirectory.open指定索引目录
        FSDirectory directory = FSDirectory.open(new File("D:\\luceneIndex"));
        //2.声明分词器为标准分词器 StandardAnalyzer 参数1：设置分词器版本
        //将标准分词器改成ik分词器
        Analyzer analyzer = new IKAnalyzer();
        //3.声明索引库写出配置IndexWriterConfig  参数1：设置版本  参数2：需要分词器
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_3,analyzer);
        //4.声明索引库写入对象IndexWriter(参数1：需要索引库位置 ，参数2：)
        IndexWriter indexWriter = new IndexWriter(directory,config);
        //5.声明File指定读取本地磁盘文件路径
        File fileDir = new File("D:\\searchsource");

        //6.file对象通过listFiles得到文件路径下的所有文件
        File[] files = fileDir.listFiles();

        //7.循环显示并通过writer将doc保存索引库
        for (File file : files) {

            //文件名 file.getName()文件名，
            System.out.println("文件名:"+file.getName());
            //文件内容 FileUtils.readFileToString(file)
            System.out.println("文件内容:"+ FileUtils.readFileToString(file));
            //文件大小 FileUtils.sizeOf(file)
            System.out.println("文件大小:"+ FileUtils.sizeOf(file));
            //文件路径 file.getPath()
            System.out.println("文件路径"+file.getPath());
            //8.声明Document文档对象
            /**
             * TextField 文本存储
             * LongField 存储数值
             * Store.YES 需要存储内容到索引库
             */
            Document document = new Document();
            document.add(new TextField( "fileName", file.getName(), Field.Store.YES));
            document.add(new TextField( "fileContent", FileUtils.readFileToString(file), Field.Store.YES));
            document.add(new LongField( "fileSize", FileUtils.sizeOf(file), Field.Store.YES));
            document.add(new TextField( "filePath", file.getPath(), Field.Store.YES));

            //9.writer对象将doc对象写入索引库
            indexWriter.addDocument(document);
        }

        //10.提交数据
        indexWriter.commit();
        //11.writer关闭
        indexWriter.close();
    }

    @Test
    public void deleteIndex() throws IOException {

        //指定索引目录
        FSDirectory directory = FSDirectory.open(new File("D:\\luceneIndex"));
        //指定分词器为标准分词器 StandardAnalyzer
        //StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_4_10_3);
        Analyzer analyzer = new IKAnalyzer();
        //指定索引库写出配置   参数一，版本   参数二，分词器
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_3,analyzer);

        //创建索引库写入对象，参数一指定目录  参数二指定配置
        IndexWriter writer = new IndexWriter(directory,config);

        //删除索引库中的文档对象
        writer.deleteDocuments(new Term("fileName","传智播客"));

        //删除所有索引库中数据
        //writer.deleteAll();

        //提交数据
        writer.commit();
        //关闭
        writer.close();
    }
}
