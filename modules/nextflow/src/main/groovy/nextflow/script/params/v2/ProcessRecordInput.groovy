/*
 * Copyright 2013-2026, Seqera Labs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nextflow.script.params.v2

import groovy.transform.CompileStatic
import groovyx.gpars.dataflow.DataflowReadChannel

/**
 * Models a named record input, which binds the received record to a
 * top-level variable and retains the declared record components for
 * validation.
 *
 * @author Ben Sherman <bentshermann@gmail.com>
 */
@CompileStatic
class ProcessRecordInput extends ProcessInput {

    private List<ProcessInput> components

    ProcessRecordInput(String name, List<ProcessInput> components, Class type, boolean optional) {
        super(name, type, optional)
        this.components = components
    }

    List<ProcessInput> getComponents() {
        return components
    }

    @Override
    ProcessRecordInput clone() {
        final result = (ProcessRecordInput)super.clone()
        result.components = new ArrayList<>(components.size())
        for( final component : components )
            result.components.add(component.clone())
        return result
    }

    /// LEGACY METHODS

    @Override
    DataflowReadChannel getInChannel() {
        throw new UnsupportedOperationException()
    }

    @Override
    Object getRawChannel() {
        throw new UnsupportedOperationException()
    }

    @Override
    def decodeInputs( List values ) {
        throw new UnsupportedOperationException()
    }

}