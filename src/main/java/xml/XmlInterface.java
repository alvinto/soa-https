package xml;

/**
 * 构造及解析xml
 * 基本的解析方式有两种,一种叫SAX，另一种叫DOM。
 * SAX是基于事件流的解析,DOM是基于XML文档树结构的解析。
 * 可以使用SAX来查询或者阅读XML文档。
 * SAX可以快速扫描一个大型的XML文档，当它找到查询标准时就会立即停止，然后再处理之。
 * DOM是把XML全部加载到内存中建立一棵树之后再进行处理。所以DOM不适合处理大型的XML【会产生内存的急剧膨胀】。

 同理，DOM的弱项就是SAX的强项，SAX不必把全部的xml都加载到内存中。
 但是SAX的缺点也很明显，它只能对文件顺序解析一遍，不支持对文件的随意存取。
 SAX也仅仅能够读取文件的内容，并不能修改内容。DOM可以随意修改文件树，从而修改了xml文件。
 * Created by alvin on 2016/5/23.
 */
public interface XmlInterface {
    /**
     * 建立xml
     * @param fileName
     */
    public void createXml(String fileName);

    /**
     * 解析xml
     * @param fileName
     */
    public void parserXml(String fileName);

}
