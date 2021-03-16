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

package org.nd4j.serde.base64;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.nd4j.linalg.BaseNd4jTestWithBackends;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.factory.Nd4jBackend;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Nd4jBase64Test extends BaseNd4jTestWithBackends {


    @Override
    public char ordering() {
        return 'c';
    }

    @Test
    @ParameterizedTest
    @MethodSource("org.nd4j.linalg.BaseNd4jTest#configs")
    public void testBase64(Nd4jBackend backend) throws Exception {
        INDArray arr = Nd4j.linspace(1, 4, 4);
        String base64 = Nd4jBase64.base64String(arr);
        INDArray from = Nd4jBase64.fromBase64(base64);
        assertEquals(arr, from);
    }
}