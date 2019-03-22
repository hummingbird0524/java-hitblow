package action;

import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import gui.HBFrame;
import logic.HBLogic;

/**
 * Hit＆Blow 判定アクションClass
 * 
 * @author	y_nishikawa
 */
public class JudgeAction{
	/** Frame)主フレーム */
	HBFrame	win;
	
	// ==============================================================================================================
	
	/**
	 * コンストラクター
	 * @param	win	(HBFrame)ウィンドウ
	 */
	public JudgeAction(HBFrame win){
		this.win = win;
	}
	
	/**
	 * 判定処理
	 * 
	 * @param	answer	(String)正解文字列
	 * @param	tryCnt	(int)試行回数
	 */
	public void judge(String answer, int tryCnt){
		try{
			// 入力値取得
			String	input = win.txtInput.getText().trim();
			
//			// 入力値チェック
//			HBLogic.checkStr(input);
			
			// 入力値判定
			HashMap<String, Object>	result = HBLogic.checkAnswer(input, answer);
			
			StringBuffer	sb = new StringBuffer();
			sb.append(win.txaHistory.getText());
			sb.append("\n");
			sb.append("●" + (++tryCnt) + "回目");
			sb.append("\t");
			sb.append(result.get("hit") + " HIT／" + result.get("blow") + " BLOW");
			
			if((boolean)result.get("result")){
				// クリアの場合
				sb.append("\n");
				sb.append("★★★ GAME CLEAR ★★★");
				
				// 判定ボタンを無効化
				win.btnJudge.setEnabled(false);
			}
			
			// 履歴に追加
			win.txaHistory.setText(sb.toString());
			
		}catch(IllegalArgumentException iae){
			System.out.println(iae.getMessage());
			
			// エラーダイアログ表示
			dispErrorMsg(iae.getMessage());
			
		}finally{
			// 入力欄クリア
			win.txtInput.setText("");
		}
	}
	
	/**
	 * エラーダイアログ表示
	 * 
	 * @param	errMsg	(String)エラーメッセージ
	 */
	public void dispErrorMsg(String errMsg){
		JLabel	lblErrMsg = new JLabel(errMsg);
		JOptionPane.showMessageDialog(win, lblErrMsg);
	}
}
