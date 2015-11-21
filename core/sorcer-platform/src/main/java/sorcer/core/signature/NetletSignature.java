/*
 * Copyright 2010 the original author or authors.
 * Copyright 2010 SorcerSoft.org.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sorcer.core.signature;

import net.jini.core.transaction.TransactionException;
import sorcer.co.tuple.Path;
import sorcer.netlet.ScriptExerter;
import sorcer.service.Arg;
import sorcer.service.Mogram;
import sorcer.service.MogramException;
import sorcer.util.Sorcer;

import java.io.File;
import java.rmi.RemoteException;

import static sorcer.eo.operator.evaluate;

/**
 * Created by Mike Sobolewski on 8/3/15.
 */
public class NetletSignature extends ServiceSignature {

    protected Path serviceSource;

    public NetletSignature(String name, Path source) {
        this.name = name;
        this.serviceSource = source;
    }

    public NetletSignature(Path source) {
        this.serviceSource = source;
    }

    public Path getServicePath() {
        return serviceSource;
    }

    public String getServiceSource() {
        return serviceSource.path();
    }

    public void setServiceSource(Path serviceSource) {
        this.serviceSource = serviceSource;
    }


    @Override
    public Object exec(Arg... args) throws MogramException, RemoteException, TransactionException {
        try {
            ScriptExerter se = new ScriptExerter(System.out, null, Sorcer.getWebsterUrl(), true);
            se.readFile(new File(serviceSource.getName()));
            return evaluate((Mogram)se.parse());
        } catch (Throwable throwable) {
            throw new MogramException(throwable);
        }
    }
}
