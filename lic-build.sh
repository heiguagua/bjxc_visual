#!/bin/sh


mvcpath="src/main/resources/spring/spring-mvc.xml"
webpath="src/main/webapp/WEB-INF/web.xml"
#webpath="web.xml"
#mvcpath="spring-mvc.xml"

####================函数定义=================####
#获取起始行，参数1($1):开始查找的行数，参数2($2):查找的关键字,参数3($3):查找的文件
function getStartNum() {
n=$1
#获取上一行命令:((n1=$n1-1))
while((n=$n-1));
do
        if [ $n -lt 1 ];then
                break
        fi
        upline=$(echo $(awk 'NR=='$n' {print $1}' $3))
        #echo $upline

        #判断上一行内容
        content=$(echo "$upline" | grep "$2")
        if [ "$content" != "" ];then
				i=$n
                break
        fi
done
return $n
}
#获取行。参数1($1):开始查找的行数，参数2($2):查找的关键字，参数3($3):查找的文件
function getEndNum() {
n=$1
while((n=$n+1));
do
	if [ $n -gt 174 ];then
		break
	fi      
        upline=$(echo $(awk 'NR=='$n' {print $1}' $3))
        echo end:$upline

        #判断上一行内容
        content=$(echo "$upline" | grep "$2")
        if [ "$content" != "" ];then
				j=$n
                break
        fi
done
return $n
}


####====================1.处理web.xml=====================####
#去掉空行
#sed -i '/^$/d' $webpath
#获取"<filter-name>licFilter"所在行号
result=$(echo $(sed -n '/<filter-name>licFilter/=' $webpath))
n1=$(echo $result|awk '{print $1}')
n2=$(echo $result|awk '{print $2}')

i=0
j=0
#找到Lic的<filter>起始行和结束行
getStartNum $n1 "<filter>" "$webpath"
getEndNum $n1 "</filter>" "$webpath"
#开启License
if [ $i -ne 0 -a $j -ne 0 ];then
sed -i ''$i','$j'{s/<!--//g;s/-->//g}' $webpath
fi

i=0
j=0
#找到Lic的<filter-mapping>起始行和结束行
getStartNum $n2 "<filter-mapping>" "$webpath"
getEndNum $n2 "</filter-mapping>" "$webpath"
if [ $i -ne 0 -a $j -ne 0 ];then
sed -i ''$i','$j'{s/<!--//g;s/-->//g}' $webpath
fi


####================2.处理spring-mvc.xml=================####
#获取"com.chinawiserv.dsp.base.common.inteceptor.SpringInteceptor"所在行号
result=$(echo $(sed -n '/com.chinawiserv.dsp.base.common.inteceptor.SpringInteceptor/=' $mvcpath))
n1=$(echo $result|awk '{print $1}')
echo $n1
i=0
j=0
#找到Lic的<mvc:interceptor>起始行和结束行
getStartNum $n1 "<mvc:interceptor>" $mvcpath
getEndNum $n1 "</mvc:interceptor>" $mvcpath
echo $i,$j
#开启License
sed -i ''$i','$j'{s/<!--//g;s/-->//g}' $mvcpath
i=0
j=0
#如果<mvc:interceptors>被注释，需要开启
i=$(echo $(sed -n '/<mvc:interceptors>/=' $mvcpath))
j=$(echo $(sed -n '/<\/mvc:interceptors>/=' $mvcpath))
sed -i ''$i'{s/<!--//g;s/-->//g}' $mvcpath
sed -i ''$j'{s/<!--//g;s/-->//g}' $mvcpath


