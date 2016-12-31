package text;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class Text extends JFrame{
   
    public static void main(String []args){ 
    	final JFrame jf = new JFrame("�½��ı��ĵ�");
    	jf.setSize(500, 600);
    	jf.setLocation(450,100);
    	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���ʱͬʱ��������
    	
    	
    	JPanel jp = new JPanel();
    	
    	final JTextArea jta = new JTextArea();
    	jp.setLayout(new BorderLayout());//����BorderLayout����JTextArea�Զ�����
    	JScrollPane jsp=new JScrollPane(jta);
    	jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//ǿ�ƹ�������ʾ
    	
	    JMenuBar jmb = new JMenuBar();//����һ���˵���
	
	    JMenu jm1 = new JMenu("�ļ�");//�����˵����ļ���
	    JMenuItem jmt1_1 = new JMenuItem("��");
	    JMenuItem jmt1_2 = new JMenuItem("����");
	    JMenuItem jmt1_3 = new JMenuItem("�˳�");
	    
	    jm1.add(jmt1_1);
	    jm1.addSeparator();
	    jm1.add(jmt1_2);
	    jm1.addSeparator();
	    jm1.add(jmt1_3);
	
	    JMenu jm2 = new JMenu("�༭");//�����˵����༭��
	    JMenuItem jmt2_1 = new JMenuItem("����");
	    JMenuItem jmt2_2 = new JMenuItem("����");
	    JMenuItem jmt2_3 = new JMenuItem("ճ��");
	    
	    jm2.add(jmt2_1);
	    jm2.addSeparator();
	    jm2.add(jmt2_2);
	    jm2.addSeparator();
	    jm2.add(jmt2_3);
	    
	    JMenu jm3 = new JMenu("��ʽ");//�����˵�����ʽ��
	    JMenu jmt3_1 = new JMenu("��ʽ����");
	    JMenuItem jmt3_1_1 = new JMenuItem("�Զ�����");
	    JMenuItem jmt3_1_2 = new JMenuItem("ȡ���Զ�����");
	    JMenuItem jmt3_1_3 = new JMenuItem("���в�����");
	    JMenuItem jmt3_1_4 = new JMenuItem("ȡ�����в�����");
	    
	    jmt3_1.add(jmt3_1_1);
	    jmt3_1.addSeparator();
	    jmt3_1.add(jmt3_1_2);
	    jmt3_1.addSeparator();
	    jmt3_1.add(jmt3_1_3);
	    jmt3_1.addSeparator();
	    jmt3_1.add(jmt3_1_4);
	    
	    jm3.add(jmt3_1);
	    jmb.add(jm1);
	    jmb.add(jm2);
	    jmb.add(jm3);
	    
	    //������
	    jp.add(jsp);//���������
	    jf.add(jp);
	    jf.setJMenuBar(jmb);
	    
	    //����Ҽ��˵�
	    final JPopupMenu popupMenu = new  JPopupMenu();
		JMenuItem menuOpen = new JMenuItem("��");
		JMenuItem menuItemSave = new JMenuItem("����");
		JMenuItem menuItemCopy = new JMenuItem("����");
		JMenuItem menuItemCut = new JMenuItem("����");
		JMenuItem menuItemPaste = new JMenuItem("ճ��");
		popupMenu.add(menuOpen);
		popupMenu.addSeparator();//��ӷָ���
		popupMenu.add(menuItemSave);
		popupMenu.addSeparator();//��ӷָ���
		popupMenu.add(menuItemCopy);
		popupMenu.addSeparator();//��ӷָ���
		popupMenu.add(menuItemCut);
		popupMenu.addSeparator();//��ӷָ���
		popupMenu.add(menuItemPaste);
		jta.add(popupMenu);
	    
    	
    	//����¼�
    	//��"��"�˵���ע���¼�������
    	jmt1_1.addActionListener(new ActionListener() {
    	      @Override
    	      public void actionPerformed(ActionEvent e) {
    	    	  FileDialog fd1 = new FileDialog(jf, "��",FileDialog.LOAD);//����һ�����ļ��ĶԻ���
    	    	  fd1.setVisible(true);//�Ի������
    	    	  String strFile = fd1.getDirectory() + fd1.getFile();//getDirectory()��ȡfd�Ի����Ŀ¼��getFile()��ȡfd�Ի����ѡ���ļ�
    	    	  if(strFile!=null){
    	    		  try {
    	    			  FileInputStream fis = new FileInputStream(strFile);

    	    			  //fi.available()������һ�ζԴ����������õķ������Բ��������شӴ���������ȡ�����������Ĺ���ʣ���ֽ���
    	    			  byte bt[] = new byte[fis.available()];

    	    			  fis.read(bt);
    	    			  jta.setText(new String(bt));//��ֵ�����ı�����(new String(bt)���ַ�ת�����ַ���).
    	    			  fis.close();
    	    		  } catch (FileNotFoundException e1) {
    	    			  // TODO �Զ����ɵ� catch ��
    	    			  e1.printStackTrace();
    	    		  } catch (IOException e1) {
    	    			  // TODO �Զ����ɵ� catch ��
    	    			  e1.printStackTrace();
    	    		  }
    	    	  }
    	      }
    	});
    	//��"����"�˵���ע���¼�������
    	jmt1_2.addActionListener(new ActionListener() {
    	      @Override
    	      public void actionPerformed(ActionEvent e) {
    	    	  

    	    	  FileDialog fd2 = new FileDialog(jf, "����", FileDialog.SAVE);//FileDialog.SAVE�˳���ֵָʾ�ļ��Ի��򴰿ڵ������ǲ���Ҫд����ļ���
    	    	  fd2.setVisible(true);//�Ի������
    	    	  String fname = fd2.getDirectory();//getDirectory()��ȡfd2�Ի����Ŀ¼,ò�Ʋ��ܷ���ǰһ�д���ǰ
    	    	  File file = new File(fd2.getFile() + ".txt");//fd2.getFile()���fd2�Ի����е�ѡ���ļ�
    	    	  String s = jta.getText();
    	    	  try {
    	    		  BufferedWriter bw = new BufferedWriter(new FileWriter(fname+file));
					bw.write(s);
					bw.close();
				} catch (Exception ioe) {
					ioe.printStackTrace();
				}

    	      }
    	});
    	//�����˳����˵���ע���¼�������
    	jmt1_3.addActionListener(new ActionListener() {
    	      @Override
    	      public void actionPerformed(ActionEvent e) {
    	            System.exit(0);
    	      }
    	});
    	//����
    	jmt2_1.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			jta.copy();
    		}
    	});
    	//����
    	jmt2_2.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			jta.cut();
    		}
    	});
    	//ճ��
    	jmt2_3.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			jta.paste();
    		}
    	});
    	//�Զ�����
    	jmt3_1_1.addActionListener(new ActionListener() {
    	      @Override
    	      public void actionPerformed(ActionEvent e) {
    	    	  jta.setLineWrap(true);   	//�Զ�����
    	      }
    	});
    	//ȡ���Զ�����
    	jmt3_1_2.addActionListener(new ActionListener() {
    	      @Override
    	      public void actionPerformed(ActionEvent e) {
    	    	  jta.setLineWrap(false);
    	      }
    	});
    	//���в�����
    	jmt3_1_3.addActionListener(new ActionListener() {
    	      @Override
    	      public void actionPerformed(ActionEvent e) {
    	            jta.setWrapStyleWord(true);;
    	      }
    	});
    	//ȡ�����в�����
    	jmt3_1_4.addActionListener(new ActionListener() {
    	      @Override
    	      public void actionPerformed(ActionEvent e) {
    	            jta.setWrapStyleWord(false);
    	      }
    	});
  	
    	//��JPanelʵ������panel����ע���¼�������
    	jta.addMouseListener(new MouseListener() {
    	      @Override
    	      public void mousePressed(MouseEvent e) {
    	            int mods=e.getModifiers(); 
    	            if((mods&InputEvent.BUTTON3_MASK)!=0){
    	                  //����show������ʾ����ʽ�˵�
    	                  popupMenu.show(jta,e.getX(),e.getY());
    	            }
    	      }

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}
    	});
    	//�����򿪡��˵���ע���¼�������
    	menuOpen.addActionListener(new ActionListener() {
    	      @Override
    	      public void actionPerformed(ActionEvent e) {
    	    	  FileDialog fd1 = new FileDialog(jf, "��",FileDialog.LOAD);//����һ�����ļ��ĶԻ���
    	    	  fd1.setVisible(true);//�Ի������
    	    	  String strFile = fd1.getDirectory() + fd1.getFile();//getDirectory()��ȡfd�Ի����Ŀ¼��getFile()��ȡfd�Ի����ѡ���ļ�
    	    	  if(strFile!=null){
    	    		  try {
    	    			  FileInputStream fis = new FileInputStream(strFile);

    	    			  //fi.available()������һ�ζԴ����������õķ������Բ��������شӴ���������ȡ�����������Ĺ���ʣ���ֽ���
    	    			  byte bt[] = new byte[fis.available()];

    	    			  fis.read(bt);
    	    			  jta.setText(new String(bt));//��ֵ�����ı�����(new String(bt)���ַ�ת�����ַ���).
    	    			  fis.close();
    	    		  } catch (FileNotFoundException e1) {
    	    			  // TODO �Զ����ɵ� catch ��
    	    			  e1.printStackTrace();
    	    		  } catch (IOException e1) {
    	    			  // TODO �Զ����ɵ� catch ��
    	    			  e1.printStackTrace();
    	    		  }
    	    	  }
    	      }
    	});
    	//�������桰�˵���ע���¼�������
    	menuItemSave.addActionListener(new ActionListener() {
    	      @Override
    	      public void actionPerformed(ActionEvent e) {
    	            System.exit(0);
    	      }
    	});
    	//�������ơ��˵���ע���¼�������
    	menuItemCopy.addActionListener(new ActionListener() {
    	      @Override
    	      public void actionPerformed(ActionEvent e) {
    	    	  jta.copy();
    	      }
    	});
    	//�������С��˵���ע���¼�������
    	menuItemCut.addActionListener(new ActionListener() {
    	      @Override
    	      public void actionPerformed(ActionEvent e) {
    	    	  jta.cut();
    	      }
    	});
    	//����ճ�����˵���ע���¼�������
    	menuItemPaste.addActionListener(new ActionListener() {
    	      @Override
    	      public void actionPerformed(ActionEvent e) {
    	    	  jta.paste();
    	      }
    	});


    	jf.setVisible(true);//����
    }
}

