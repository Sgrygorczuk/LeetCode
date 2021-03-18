package com.leet_code.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.leet_code.game.linkedLists.LinkedList;
import com.leet_code.game.problems.P1108;
import com.leet_code.game.problems.P1221;
import com.leet_code.game.problems.P1672;
import com.leet_code.game.recursion.PrincipleOfRecursion;

public class LeetCode{
	public LeetCode() {
		//"addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"
		//[[],[1],[3],[1,2],[1],[1],[1]]
		LinkedList linkedList = new LinkedList();
		linkedList.addAtHead(1);
		linkedList.addAtTail(3);
		linkedList.addAtIndex(1,2);
		System.out.println(linkedList.get(1));
		linkedList.deleteAtIndex(1);
		System.out.println(linkedList.get(1) + "\n");
		linkedList.printList();
	}
}
