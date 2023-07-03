/*
 * Copyright 2022 The FeatHub Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.feathub.flink.udf;

import org.apache.flink.table.api.DataTypes;
import org.apache.flink.table.types.DataType;

import java.util.List;

/** Time windowed collect list aggregation function. */
public class TimeWindowedCollectListAggFunc extends AbstractTimeWindowedAggFunc<Object, Object> {
    @Override
    protected Object getValue(List<Object> values) {
        return CollectListAggFunc.toArray(values);
    }

    @Override
    protected DataType getResultDataType(DataType valueDataType) {
        return DataTypes.ARRAY(valueDataType);
    }
}