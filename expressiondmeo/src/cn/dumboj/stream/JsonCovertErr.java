package cn.dumboj.stream;

import javax.swing.text.html.Option;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

/***
 * JSON转对象包含Double浮点型数据时，在赋值前被转换为无符号数据后才赋值给double问题探讨
 * todo
 * */
public class JsonCovertErr {
    public static void main(String[] args) {
        byte[] resource = "{eta:{'content':'this is the data';'links':[{'eta':-4.2134568781,'autoLr':-2.6597814},{'eta':-4.2134568781,'autoLr':-2.6597814}]}}".getBytes(StandardCharsets.UTF_8);
        System.out.println("染了风寒感冒了，暂歇！");
    }

}
class  Eta{
   private String content;
   private List<Link> links;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    private class Link {
       private double eta;
       private double autoLr;

        public double getEta() {
            return eta;
        }

        public void setEta(double eta) {
            this.eta = eta;
        }

        public double getAutoLr() {
            return autoLr;
        }

        public void setAutoLr(double autoLr) {
            this.autoLr = autoLr;
        }
    }
}
