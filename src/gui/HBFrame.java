package gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

/**
 * Hit＆Blow GUI関連Class
 * 
 * @author	y_nishikawa
 */
public class HBFrame extends JFrame{
	/** タイトル                  */
	private static final String	TITLE = "Hit ＆ Blow";
	/** 説明                      */
	private static final String	DESC  = "コンピューターが生成した4桁の数字を予想して、少ない回数で当てよう！";
	
	/** Label)タイトル            */
	public JLabel			lblTitle;
	/** Label)予想値              */
	public JLabel			lblForecast;
	
	/** TextField)予想値          */
	public JTextField		txtInput;
	
	/** Button)判定               */
	public JButton		btnJudge;
	/** Button)ﾘｾｯﾄ               */
	public JButton		btnReset;
	
	/** TextArea)説明             */
	public JTextArea		txaDesc;
	/** TextArea)履歴             */
	public JTextArea		txaHistory;
	
	/** ScrollPane)履歴スクロール */
	public JScrollPane	pnlScroll;
	
	// ==============================================================================================================
	
	/**
	 * コンストラクター
	 */
	public HBFrame(){
		/* **************************************************
		 * フレーム関連設定
		 * **************************************************/
		setTitle(TITLE);												// タイトル指定
		setBounds(100, 100, 300, 400);									// サイズ・位置指定
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				// 閉じるボタン処理
		getContentPane().setLayout(null);								// レイアウト指定
		setResizable(false);											// サイズ変更不可
		
		/* **************************************************
		 * タイトルラベル関連設定
		 * **************************************************/
		lblTitle    = new JLabel(TITLE);
		lblTitle.setBounds(12, 10, 260, 40);							// サイズ・位置指定
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);			// センタリング
		lblTitle.setFont(new Font("メイリオ", Font.PLAIN, 24));		// フォント指定
		add(lblTitle);
		
		/* **************************************************
		 * 説明エリア関連設定
		 * **************************************************/
		txaDesc     = new JTextArea(DESC);
		txaDesc.setBounds(22, 50, 240, 80);								// サイズ・位置指定
		txaDesc.setFont(new Font("メイリオ", Font.PLAIN, 16));			// フォント指定
		txaDesc.setBackground(this.getBackground());					// 背景色指定
		txaDesc.setLineWrap(true);										// 折り返し指定
		add(txaDesc);
		
		/* **************************************************
		 * 予想値関連設定
		 * **************************************************/
		// ラベル
		lblForecast = new JLabel("予想値：");
		lblForecast.setBounds(32, 140, 71, 30);							// サイズ・位置指定
		lblForecast.setFont(new Font("メイリオ", Font.PLAIN, 16));		// フォント指定
		add(lblForecast);
		
		// テキストボックス
		txtInput    = new JTextField();
		txtInput.setBounds(115, 140, 60, 30);							// サイズ・位置指定
		txtInput.setHorizontalAlignment(SwingConstants.CENTER);			// センタリング
		txtInput.setFont(new Font("メイリオ", Font.PLAIN, 16));		// フォント指定
		add(txtInput);
		
		/* **************************************************
		 * 判定ボタン関連設定
		 * **************************************************/
		btnJudge    = new JButton("判定");
		btnJudge.setBounds(22, 180, 140, 30);							// サイズ・位置指定
		btnJudge.setFont(new Font("メイリオ", Font.PLAIN, 18));		// フォント指定
		add(btnJudge);
		
		/* **************************************************
		 * リセットボタン関連設定
		 * **************************************************/
		btnReset    = new JButton("ﾘｾｯﾄ");
		btnReset.setBounds(172, 181, 90, 30);							// サイズ・位置指定
		btnReset.setFont(new Font("メイリオ", Font.PLAIN, 16));		// フォント指定
		add(btnReset);
		
		/* **************************************************
		 * 履歴エリア関連設定
		 * **************************************************/
		txaHistory  = new JTextArea();
		txaHistory.setText("【これまでの経過】");						// 初期値指定
		txaHistory.setFont(new Font("メイリオ", Font.PLAIN, 14));		// フォント指定
		txaHistory.setBorder(new EtchedBorder(EtchedBorder.RAISED));	// 枠線指定
		pnlScroll   = new JScrollPane(txaHistory);						// スクロール設定
		pnlScroll.setBounds(22, 220, 240, 131);							// サイズ・位置指定
		add(pnlScroll);
	}
}
