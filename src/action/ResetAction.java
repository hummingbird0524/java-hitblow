package action;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import gui.HBFrame;

public class ResetAction{
	/** Frame)主フレーム */
	HBFrame	win;
	
	// ==============================================================================================================
	
	/**
	 * コンストラクター
	 * 
	 * @param	win	(HBFrame)主フレーム
	 */
	public ResetAction(HBFrame win){
		this.win = win;
	}
	
	/**
	 * リセット処理
	 */
	public void reset(){
		// テキスト初期化
		win.txtInput.setText("");
		win.txaHistory.setText("【これまでの経過】");
		
		// 判定ボタンを有効化
		win.btnJudge.setEnabled(true);
	}
	
	/**
	 * 確認メッセージダイアログ表示
	 * 
	 * @param	errMsg	(String)メッセージ
	 * @return	(int)	0:Yes / 1:No
	 */
	public int dispConfirm(String msg){
		JLabel	lblMsg = new JLabel(msg);
		return	JOptionPane.showConfirmDialog(win, lblMsg, "諦める？", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
	}
}
