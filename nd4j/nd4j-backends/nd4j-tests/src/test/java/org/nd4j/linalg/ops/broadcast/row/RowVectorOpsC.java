/*
 *  ******************************************************************************
 *  *
 *  *
 *  * This program and the accompanying materials are made available under the
 *  * terms of the Apache License, Version 2.0 which is available at
 *  * https://www.apache.org/licenses/LICENSE-2.0.
 *  *
 *  *  See the NOTICE file distributed with this work for additional
 *  *  information regarding copyright ownership.
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  * License for the specific language governing permissions and limitations
 *  * under the License.
 *  *
 *  * SPDX-License-Identifier: Apache-2.0
 *  *****************************************************************************
 */

package org.nd4j.linalg.ops.broadcast.row;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import org.nd4j.linalg.BaseNd4jTestWithBackends;
import org.nd4j.linalg.api.buffer.DataType;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.factory.Nd4jBackend;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Adam Gibson
 */

public class RowVectorOpsC extends BaseNd4jTestWithBackends {



    @Test
    @ParameterizedTest
    @MethodSource("org.nd4j.linalg.BaseNd4jTest#configs")
    public void testAddi(Nd4jBackend backend) {
        INDArray arr = Nd4j.linspace(1, 4, 4, DataType.DOUBLE).reshape(2, 2);
        arr.addiRowVector(Nd4j.create(new double[] {1, 2}));
        INDArray assertion = Nd4j.create(new double[][] {{2, 4}, {4, 6}});
        assertEquals(assertion, arr);
    }

    @Override
    public char ordering() {
        return 'c';
    }
}
