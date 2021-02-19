package com.leet_code.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.leet_code.game.problems.P1108;
import com.leet_code.game.problems.P1221;
import com.leet_code.game.problems.P1672;

public class LeetCode{
	public LeetCode() {
		//TODO P1684
		P1221 a = new P1221();
		System.out.println(a.balancedStringSplit("RLLLLRRRLR"));
	}
}
