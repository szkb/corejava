//package com.study.basicknowledge.comparedatabse; /**
// * 比对两份excel或者两份sheet是否相同 有精准匹配/模糊匹配两种方式
// * @author AnndyTou
// * @Time 2018-07-17
// * @Detail
// * */
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 调用RWExcel.java 获取两份excel封装成ArrrayList集合 通过集合的下标进行比对
// */
//
//public class CompareTwoExcels {
//
//	private String exportExcelFilePath;
//	private String WebExcelFilePath;
//	private boolean isPerfectMatch;
//
//	/**
//	 * 构造方法
//	 * @isPerfectMatch 表示是否需要完全匹配
//	 */
//
//	public CompareTwoExcels(String exportExcelFilePath, String WebExcelFilePath, boolean isPerfectMatch) {
//
//		this.exportExcelFilePath = exportExcelFilePath;
//		this.WebExcelFilePath = WebExcelFilePath;
//		this.isPerfectMatch = isPerfectMatch;
//	}
//
//	/**
//	 * 逻辑比对
//	 */
//
//	public void comparedExcels(int exportExcelSheetNum, int WebExcelSheetNum) {
//
//		RWExcel excel = new RWExcel(exportExcelFilePath, WebExcelFilePath);
//
//		ArrayList<List> exportExcel_list = excel.ReadExcel(exportExcelSheetNum);
//
//		ArrayList<List> WebExcel_list = excel.ReadAnotherExcel(WebExcelSheetNum);
//		// 条件判断是否完全匹配方式去匹配两份excel
//		if (isPerfectMatch) {
//			// 以web端获取的excel报表为参考 比对导出的excel报表
//			for (int i = 1; i <= WebExcel_list.size(); i++) {
//				List list1 = WebExcel_list.get(i-1);
//				List list2 = exportExcel_list.get(i-1);
//
//				if (list2.equals(list1)) {
//					String infos = "Success-----报表第" + i + "行完全匹配-------成功";
//					System.out.println(infos);
//				} else {
//					String infos = "Fail-----报表第" + i + "行Web端与导出的报表不匹配-------失败";
//					System.out.println(infos);
//				}
//			}
//
//		}else if(!isPerfectMatch){
//			// 以web端获取的excel报表为参考 比对导出的excel报表
//			for (int i = 1; i <= WebExcel_list.size(); i++) {
//				List list1 = WebExcel_list.get(i-1);
//				List list2 = exportExcel_list.get(i-1);
//
//				if(list1.size() > list2.size()){
//					System.out.println("Fail-----第"+i+"行Web端大于导出的报表长度-------失败");
//				}else if(list1.size() < list2.size()){
//					System.out.println("Fail-----第"+i+"行Web端小于导出的报表长度-------失败");
//				}else{
//					for(int j = 1;j<= list1.size(); j++){
//
//						if(list2.contains(list1.get(j-1))){
//							System.out.println("Success-----第"+i+"行第"+j+"列Web端与导出的报表匹配-----成功");
//						}else{
//							System.out.println("Fail-----第"+i+"行第"+j+"列Web端与导出的报表不匹配----------失败");
//						}
//					}
//				}
//			}
//		}
//	}
//
//	/**
//	 * 调试方法
//	 * */
//
//	public static void main(String[] args) {
//		//第一份excel为web端抓取的excel  第二份excel为导出的excel false表示不精准匹配
//		CompareTwoExcels excels = new CompareTwoExcels("D:\\345.xls", "D:\\345.xls", false);
//		//选择xls的sheet下标
//		excels.comparedExcels(0, 1);
//
//	}
//
//}