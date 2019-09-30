package com.internousdev.InterStudents.util;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils
;
public class InputChecker {



	/**
	 * このプログラムは渡された値を正規表現にマッチするかを検証するものです。
	 * 使い方はdoCheckに11個の引数を渡します。後半部分には当てはまる形式にtrueを入れます。
	 * 結果はList形式で渡されることに気を付けてください。
	 * @param propertyName 項目名
	 * @param value 値
	 * @param minLength 最小文字数
	 * @param maxLength 最大文字数
	 * @param availableAlphabeticCharacters 半角英字を許容するか
	 * @param availableKanji 漢字を許容するか
	 * @param availableHiragana ひらがなを許容するか
	 * @param availableHalfWidthDigit 半角数字を許容するか
	 * @param availableKatakana カタカナを許容するか
	 * @param availableHalfWidthSpace スペースを許容するか
	 * @return エラーメッセージのリスト
	 */
	public List<String> doCheck(String propertyName,String value,int minLength,int maxLength,boolean availableAlphabeticCharacters,boolean availableKanji,boolean availableHiragana,boolean availableHalfWidthDigit,boolean availableKatakana,boolean availableHalfWidthSpace){

		//検証した結果を入れるList
		List<String> stringList = new ArrayList<String>();
		List<String> characterTypeList = new ArrayList<String>();

		//入力欄が空かどうかを検証します
		if(StringUtils.isEmpty(value)){
			stringList.add(propertyName + "を入力してください。");
		}

		//入力欄が最小文字数以上、最大文字数以下かどうかを検証します
		if(value.length() < minLength || value.length() > maxLength){
			stringList.add(propertyName + "は" + minLength + "文字以上" + maxLength + "文字以下で入力してください。");
		}

		///////////入力された文字のタイプから何を判別するか決めます//////////
		String regularExpression = "";



		if(availableAlphabeticCharacters || availableKanji || availableHiragana || availableHalfWidthDigit || availableKatakana || availableHalfWidthSpace){
			regularExpression = "[";
		}

		if(availableAlphabeticCharacters){
			regularExpression +="a-zA-Z";
			characterTypeList.add("半角英字");
		}

		if(availableKanji){
			regularExpression +="一-龠々";
			characterTypeList.add("漢字");
		}

		if(availableHiragana){
			regularExpression +="ぁ-んー";
			characterTypeList.add("ひらがな");
		}

		if(availableHalfWidthDigit){
			regularExpression +="0-9-";
			characterTypeList.add("半角数字");
		}

		if(availableKatakana){
			regularExpression +="ァ-ヺ";
			characterTypeList.add("カタカナ");
		}

		if(availableHalfWidthSpace){
			regularExpression +=" 　";
			characterTypeList.add("スペース");
		}

		if(!StringUtils.isEmpty(regularExpression)){
			regularExpression +="]+";
		}
		////////////////////////////ここまで///////////////////////////

		//判別した項目に応じてエラーメッセージを返します
		String characterType = "";
		for(int i = 0;i < characterTypeList.size();i++){
			if(i == 0){
				characterType += characterTypeList.get(i).toString();
			}else{
				characterType += "、" + characterTypeList.get(i).toString();
			}
		}

		if(!value.matches(regularExpression)&&!value.equals("")){
			stringList.add(propertyName + "は" + characterType + "で入力してください。");
		}

		return stringList;
	}
}
