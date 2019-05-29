package cn.itcast.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

public class QueryIndex {

    @Test
    public void queryIndex() throws Exception {
        //1.创建索引库读取对象DirectoryReader.open
        DirectoryReader reader = DirectoryReader.open(FSDirectory.open(new File("D:\\luceneIndex")));
        //2.声明IndexSearcher的搜索对象
        IndexSearcher searcher = new IndexSearcher(reader);
        //3.声明MatchAllDocsQuery查询全部对象
        //Query query = new MatchAllDocsQuery();

        //TermQuery词条查询
        //Query query = new TermQuery(new Term("fileName","传智播客"));

        //数值范围查询  参数1：查询的域，参数2：起始字节数值，参数3：结束字节数值，参数4：包含起始，参数5：包含结束
        //Query query = NumericRangeQuery.newLongRange("fileSize",1L,50L,true,true);

        //通过QueryParser 可以将搜索内容也通过分词器进行分词  单域查询
        String searchStr="传智播客培养了很多优秀的IT高科技人才";

        QueryParser parser = new QueryParser("fileName", new IKAnalyzer());
        Query query = parser.parse(searchStr);

       //多域查询
        /*String[] fileds = {"fileName", "fileContent"};
        MultiFieldQueryParser parser = new MultiFieldQueryParser(fileds,new IKAnalyzer());
        Query query = parser.parse(searchStr);*/

        //4.通过indexSearcher对象的search方法进行查询 参数1：需要查询条件对象 参数2：查询条数
        TopDocs docs = searcher.search(query, 10);
        //5.topDocs.scoreDocs方法获取文档集合
        ScoreDoc[] scoreDocs = docs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            //6.循环文档集合，通过文档.doc获取到文档ID
            System.out.println("文档id===="+scoreDoc.doc);
            //7.循环内通过indexSearcher.doc(文档.doc)获取到文档对象
            Document doc = searcher.doc(scoreDoc.doc);

            //显示文档内容
            System.out.println("名称"+doc.getField("fileName"));
            System.out.println("内容"+doc.getField("fileContent"));
            System.out.println("大小"+doc.getField("fileSize"));
            System.out.println("路径"+doc.getField("filePath"));
        }

        //8.topDocs.totalHits可以获取符合条件的文档总数
        System.out.println("查询总记录数="+docs.totalHits);
    }


}
