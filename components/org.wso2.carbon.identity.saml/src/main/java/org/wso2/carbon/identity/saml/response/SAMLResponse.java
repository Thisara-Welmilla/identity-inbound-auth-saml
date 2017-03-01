/*
 *  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.saml.response;

import org.opensaml.saml2.core.Response;
import org.opensaml.saml2.core.impl.ResponseBuilder;
import org.wso2.carbon.identity.gateway.api.context.GatewayMessageContext;
import org.wso2.carbon.identity.gateway.api.response.GatewayResponse;
import org.wso2.carbon.identity.saml.util.SAMLSSOUtil;

public class SAMLResponse extends GatewayResponse {

    private Response response;

    protected SAMLResponse(GatewayResponseBuilder builder) {
        super(builder);
        this.response = ((SAMLResponseBuilder) builder).response;
    }

    public Response getResponse() {
        return this.response;
    }

    public static class SAMLResponseBuilder extends GatewayResponseBuilder {

        private Response response;

        public SAMLResponseBuilder(GatewayMessageContext context) {
            super(context);
            ResponseBuilder responseBuilder = new ResponseBuilder();
            this.response = responseBuilder.buildObject();
        }

        public SAMLResponseBuilder setResponse(Response response) {
            this.response = response;
            return this;
        }

        //Do the bootstrap first
        static {
            SAMLSSOUtil.doBootstrap();
        }
    }
}
