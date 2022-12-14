# 常用注解

## @XmlType

@XmlType用在class类的注解，常与@XmlRootElement，@XmlAccessorType一起使用。它有三个属性：name、propOrder、namespace，经常使用的只有前两个属性。如：

```java
@XmlType(name = "basicStruct", propOrder = {
    "intValue",
    "stringArray",
    "stringValue"
)
```



## @XmlElement

@XmlElement将java对象的属性映射为xml的节点，在使用@XmlElement时，可通过name属性改变java对象属性在xml中显示的名称。如：

```java
@XmlElement(name="Address")　　
private String yourAddress;
```



## @XmlRootElement

@XmlRootElement用于类级别的注解，对应xml的跟元素，常与 @XmlType 和 @XmlAccessorType一起使用。如：

```java
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Address {}
```



## @XmlAttribute

@XmlAttribute用于把java对象的属性映射为xml的属性,并可通过name属性为生成的xml属性指定别名。如：

```java
@XmlAttribute(name="Country")
private String state;
```



## @XmlAccessorType

@XmlAccessorType用于指定由java对象生成xml文件时对java对象属性的访问方式。常与@XmlRootElement、@XmlType一起使用。它的属性值是XmlAccessType的4个枚举值，分别为：

```
XmlAccessType.FIELD:java对象中的所有成员变量

XmlAccessType.PROPERTY：java对象中所有通过getter/setter方式访问的成员变量

XmlAccessType.PUBLIC_MEMBER：java对象中所有的public访问权限的成员变量和通过getter/setter方式访问的成员变量

XmlAccessType.NONE:java对象的所有属性都不映射为xml的元素
```

　　**注意：**@XmlAccessorType的默认访问级别是XmlAccessType.PUBLIC_MEMBER，因此，如果java对象中的private成员变量设置了public权限的getter/setter方法，就不要在private变量上使用@XmlElement和@XmlAttribute注解，否则在由java对象生成xml时会报同一个属性在java类里存在两次的错误。同理，如果@XmlAccessorType的访问权限为XmlAccessType.NONE，如果在java的成员变量上使用了@XmlElement或@XmlAttribute注解，这些成员变量依然可以映射到xml文件。



## @XmlAccessorOrder

@XmlAccessorOrder用于对java对象生成的xml元素进行排序。它有两个属性值：

```
AccessorOrder.ALPHABETICAL：对生成的xml元素按字母书序排序

XmlAccessOrder.UNDEFINED:不排序
```



## @XmlTransient

@XmlTransient用于标示在由java对象映射xml时，忽略此属性。即，在生成的xml文件中不出现此元素。



## @XmlJavaTypeAdapter

@XmlJavaTypeAdapter常用在转换比较复杂的对象时，如map类型或者格式化日期等。使用此注解时，需要自己写一个adapter类继承`XmlAdapter抽象类，并实现里面的方法。`

@XmlJavaTypeAdapter(value=xxx.class),value为自己定义的adapter类

XmlAdapter如下：

```java
public abstract class XmlAdapter<ValueType,BoundType> {
    // Do-nothing constructor for the derived classes.
    protected XmlAdapter() {}
    // Convert a value type to a bound type.
    public abstract BoundType unmarshal(ValueType v);
    // Convert a bound type to a value type.
    public abstract ValueType marshal(BoundType v);
}
```

