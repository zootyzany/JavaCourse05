//package com.example.zz.week01.algorithm;
//
//import java.util.Collection;
//
//import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
//import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
//
///**
// * 自定义分片算法
// *
// * @author zhouzeng
// *
// */
//public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
//
//	@Override
//	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
//		for (String tableName : availableTargetNames) {
//			if (tableName.endsWith(shardingValue.getValue() % 4 + "")) {
//				return tableName;
//			}
//		}
//		throw new IllegalArgumentException();
//	}
//
//}
