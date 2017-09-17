package cn.ya.javatribe.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 叶雅芳 on 2017/4/1.
 * 将字符串类型的日期转换成日期类型
 */
public class DateConverter implements Converter<String, Date>{

    @Override
    public Date convert(String source) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return simpleDateFormat.parse(source);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }
}
