package com.itheima.vrdemo.utils;


import com.itheima.vrdemo.bean.PanoramaItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sszz on 2016/12/5.
 */

public class PanoramaProvider {
	public static List<PanoramaItem> getDataList() {
		List<PanoramaItem> items = new ArrayList<PanoramaItem>();
		items.add(new PanoramaItem("滕王阁", "http://media.qicdn.detu.com/pano177051472357986990056825/thumb/500_500/panofile.jpg", "http://media.qicdn.detu.com/@/13363707-8857-C248-3CE1-64F2F24291636/source/145049/o_1arbdk2apj37df16up16um196j7.mp3"));
		items.add(new PanoramaItem("巴山大峡谷-云海日出", "http://media.qicdn.detu.com/@/17596710-5661-0192-EDC8-81F89376806/source/142048/o_1aqd3brm71svb11gqh5la5bjj17.jpg", "http://media.qicdn.detu.com/@/17596710-5661-0192-EDC8-81F89376806/source/128321/o_1amb55jqq13ma8po16aogvdrjkc.mp3"));
		items.add(new PanoramaItem("厦大", "http://media.qicdn.detu.com/pano781791479224712452691293/thumb/500_500/panofile.jpg", null));
		items.add(new PanoramaItem("西南大学经济管理学院", "http://media.qicdn.detu.com/pano573341478189386216286405/thumb/500_500/panofile.jpg", null));
		items.add(new PanoramaItem("辽宁工业大学", "http://media.qicdn.detu.com/pano476831467201488386232805/thumb/500_500/panofile.jpg", null));
		items.add(new PanoramaItem("西安海棠职业学院", "http://media.qicdn.detu.com/pano532201469338026348840893/thumb/500_500/panofile.jpg", "http://media.qicdn.detu.com/@/18192570-5756-0D36-9533-2416F77090543/source/135547/o_1aodn4afsqclli11jm5tr22kg7.mp3"));
		return items;
	}
}
