package LeetCodeDifficultQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sravan
 * Created on Feb 27, 2018
 */

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 - capacity )

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 */

// Inspired from
// https://leetcode.com/problems/lru-cache/discuss/45922/JAVA-Easy-Version-To-Understand!!!!
public class LRUCache {
	Map<Integer, DLLNode> map;
	DLLNode head;
	DLLNode tail;
	int capacity;
	int size;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		map = new HashMap<>();
		head = new DLLNode(0, 0);
		tail = new DLLNode(0, 0);
		head.next = tail;
		head.pre = null;
		tail.pre = head;
		tail.next = null;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			DLLNode node = map.get(key);
			int val = node.val;
			deleteNode(node);
			addToHead(node);
			return val;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			DLLNode node = map.get(key);
			deleteNode(node);
			node.val = value;
			addToHead(node);
		} else {
			DLLNode newNode = new DLLNode(key, value);
			map.put(key, newNode);
			if (size < capacity) {
				size++;
			} else {
				map.remove(tail.pre.key);
				deleteNode(tail.pre);
			}
			addToHead(newNode);
		}
	}

	private void deleteNode(DLLNode node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	private void addToHead(DLLNode node) {
		node.next = head.next;
		head.next.pre = node;
		node.pre = head;
		head.next = node;
	}
}

class DLLNode {
	int key;
	int val;
	DLLNode pre;
	DLLNode next;

	DLLNode(int key, int val) {
		this.key = key;
		this.val = val;
	}
}
