package cn.ya.javatribe.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 生成验证码图片
 * 
 * @author ahay
 * 
 */
/*
 * 生成验证码 
 * 分析：
 * 一、验证码由哪些组成 
 * 	1.一个矩形框（白底） 
 * 	2.四个随机产生的0~9，a~z,A~Z的数 
 * 	3.四个随机数颜色，字体，大小不同
 * 	4.图片上有干扰线 
 * 二、做一个验证码包含哪些步骤 
 * 	1.把验证码的规格做出来 
 * 	2.填充内容 
 * 	3.保存文本内容 
 * 	4.把图片保存起来
 */
public class VerifyCode {
	private Random r = new Random();
	private int w = 80; // 验证码宽度
	private int h = 32; // 验证码高度
	// 可选字体 {"宋体", "华文楷体", "黑体", "华文新魏", "华文隶书", "微软雅黑", "楷体_GB2312"}
	private String[] fontNames = { "宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312" };
	// 可选字符
	private String codes = "23456789abcdefghjkmnopqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ"; 
	private Color bgColor = new Color(255, 174, 201);//背景颜色
	private String text; // 验证码上的文本

	// 获取随机生成的颜色
	private Color randomColor() {
		int red = r.nextInt(150);
		int green = r.nextInt(150);
		int blue = r.nextInt(150);
		return new Color(red, green, blue);
	}

	// 获取随机生成的字体
	private Font randomFont() {
		int index = r.nextInt(fontNames.length);
		String fontName = fontNames[index];
		// 字形有0-常规,1-粗体,2-斜体,3-粗体和斜体
		int style = r.nextInt(4);
		int size = r.nextInt(5) + 24; // 生成随机字号, 24 ~ 28
		return new Font(fontName, style, size);
	}

	// 画干扰线
	private void drawLine(BufferedImage image) {
		int num = 3; // // 一共画3条线
		Graphics2D g2 = (Graphics2D) image.getGraphics();// 得到画笔
		// 参产生4个坐标
		for (int i = 0; i < num; i++) {
			int x1 = r.nextInt(w);
			int y1 = r.nextInt(h);
			int x2 = r.nextInt(w);
			int y2 = r.nextInt(h);
			g2.setStroke(new BasicStroke(1.5F));
			g2.setColor(Color.BLUE);//干扰线为蓝色
			g2.drawLine(x1, y1, x2, y2);
		}
	}

	// 随机产生的字符
	private char randomChar() {
		int index = r.nextInt(codes.length());
		return codes.charAt(index);
	}

	// 创建图片（只设定了大小，填充了背景）
	private BufferedImage createImage() {
		BufferedImage image = new BufferedImage(w, h,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		g2.setColor(this.bgColor); // 图片背景是白色
		g2.fillRect(0, 0, w, h); // 填充整张图片
		return image;
	}

	// 获取验证码图片
	public BufferedImage getImage() {
		BufferedImage image = createImage(); // 得到图片
		Graphics2D g2 = (Graphics2D) image.getGraphics();// 得到画笔
		StringBuilder sb = new StringBuilder();
		// 向图片中画4个字符
		for (int i = 0; i < 4; i++) {
			String s = randomChar() + "";
			sb.append(s);
			float x = i * 1.0F * w / 4; // 字符画在图片的哪个位置
			g2.setFont(randomFont());// 设置字体
			g2.setColor(randomColor());// 设置颜色
			g2.drawString(s, x, h - 5);
		}
		this.text = sb.toString();// 把生成的验证码字符串保存起来
		drawLine(image); //画干扰线
		return image;
	}

	// 获取验证码文本
	public String getText() {
		return text;
	}

	// 保存图片到指定的输出流
	public static void output(BufferedImage image, OutputStream out)
			throws IOException {
		ImageIO.write(image, "JPEG", out);
	}

}
