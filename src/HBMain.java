import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import action.JudgeAction;
import action.ResetAction;
import gui.HBFrame;
import logic.HBLogic;

/**
 * Hit＆Blow メインClass
 * 
 * @author	y_nishikawa
 */
public class HBMain{
	/** 正解     */
	static String	answer;
	/** 試行回数 */
	static int		tryCnt;
	
	// ==============================================================================================================
	
	/**
	 * main処理
	 * @param	args	(String[])引数
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					HBFrame	win = new HBFrame();
					
					/* ==================================================
					 *  FIXME ①初期化処理を書かないと！
					 * ================================================== */
					answer = HBLogic.generateAnswer();
					tryCnt = 0;
					
					/* **************************************************
					 * [判定]ボタンクリック時の動作設定
					 * **************************************************/
					win.btnJudge.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							JudgeAction	ja     = new JudgeAction(win);
							String			input  = null;
							String			result = null;
							
							// 入力値取得
							input = win.txtInput.getText().trim();
							
							// 入力値チェック
							result = HBLogic.checkStr(input);
							
							/* ==================================================
							 *  FIXME ②判定処理を書かないと！
							 * ================================================== */
							if(result == null){
								ja.judge(answer, tryCnt++);
							}else{
								ja.dispErrorMsg(result);
							}
						}
					});
					
					/* **************************************************
					 * [ﾘｾｯﾄ]ボタンクリック時の動作設定
					 * **************************************************/
					win.btnReset.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							ResetAction	ra  = new ResetAction(win);
							
							/* ==================================================
							 *  FIXME ③リセット処理を書かないと！
							 * ================================================== */
							if(ra.dispConfirm("リセットする？") == 0){
								// リセット処理
								ra.reset();
								
								// 初期化
								answer = HBLogic.generateAnswer();
								tryCnt = 0;
							}
						}
					});
					
					// ウィンドウを表示する
					win.setVisible(true);
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
}
