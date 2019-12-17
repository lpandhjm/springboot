package com.pei.liu.springboot.demo.spring.ioc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @description：ioc简单实现
 * @author：liupei
 * @create: 2019-12-04 18:57
 * @version: 1.0$
 */
public class SimpleIoc {


    private Map<String, Object> beanMap = new HashMap<>();

    public SimpleIoc(String location) throws Exception {
        loadBean(location);
    }

    private void register(String id, Object bean) {
        beanMap.put(id, bean);
    }

    private void loadBean(String location) throws Exception {
        //加载xml
        InputStream inputStream = new FileInputStream(location);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputStream);
        Element root = document.getDocumentElement();
        NodeList nodeList = root.getChildNodes();
        //遍历<bean>标签
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element){
                Element element = (Element) node;
                String id = element.getAttribute("id");
                String className = element.getAttribute("class");
                //加载bean
                Class beanClass= Class.forName(className);

                Object bean =beanClass.newInstance();
                // 遍历 <property> 标签
                NodeList propertyNodeList = element.getElementsByTagName("property");
                for (int j = 0; j < propertyNodeList.getLength(); j++) {
                    Node propertyNode =propertyNodeList.item(j);
                    if (propertyNode instanceof Element) {
                        Element propertyElement = (Element) propertyNode;
                        String name =propertyElement.getAttribute("name");
                        String value = propertyElement.getAttribute("value");
                        // 利用反射将 bean 相关字段访问权限设为可访问
                        Field declaredField = bean.getClass().getDeclaredField(name);
                        //设置为true 反射才能访问私有变量
                        declaredField.setAccessible(true);
                        if (value != null && value.length() > 0) {
                            declaredField.set(bean, value);
                        } else {
                            String ref = propertyElement.getAttribute("ref");
                            if (ref == null || ref.length() == 0) {
                                throw new Exception("错误的xml文件");
                            }
                            declaredField.set(bean,getBean(ref));
                        }
                        registerBean(id, bean);
                    }
                }
            }
        }

    }

    public Object getBean(String ref) {
        return  beanMap.get(ref);
    }

    private void registerBean(String id, Object bean) {
        beanMap.put(id,bean);
    }

}
