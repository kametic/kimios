/*
 * Kimios - Document Management System Software
 * Copyright (C) 2012-2013  DevLib'
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kimios.kernel.system;

import java.io.File;
import java.util.List;

import org.kimios.exceptions.ConfigException;
import org.kimios.kernel.configuration.Config;
import org.kimios.kernel.controller.IDocumentVersionController;
import org.kimios.kernel.dms.DocumentVersion;
import org.kimios.kernel.exception.DataSourceException;
import org.kimios.utils.configuration.ConfigurationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RepositoryCleaner implements Runnable
{
    private boolean stop = false;

    private static Logger log = LoggerFactory.getLogger(RepositoryCleaner.class);

    private static Thread thrc;

    private IDocumentVersionController versionController;

    public IDocumentVersionController getVersionController()
    {
        return versionController;
    }

    public void setVersionController(IDocumentVersionController versionController)
    {
        this.versionController = versionController;
    }

    public void run()
    {
        try {

            while (!this.stop) {
                List<DocumentVersion> v = versionController.getOprhansDocumentVersion();
                for (int i = 0; i < v.size(); i++) {
                    try {
                        new File(ConfigurationManager.getValue(Config.DEFAULT_REPOSITORY_PATH) +
                                v.get(i).getStoragePath()).delete();
                        versionController.deleteDocumentVersion(v.get(i).getUid());
                    } catch (ConfigException e) {
                        e.printStackTrace();
                    } catch (DataSourceException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                }
            }
        } catch (ConfigException ce) {
            ce.printStackTrace();
            this.stop();
        } catch (DataSourceException dbe) {
            dbe.printStackTrace();
            this.stop();
        } catch (Exception e) {
            e.printStackTrace();
            this.stop();
        }
    }

    public void stop()
    {
        this.stop = true;
    }

    public void startJob()
    {
        synchronized (this) {
            thrc = new Thread(this, "Kimios Repository Cleaner");
            thrc.start();
        }
    }

    public void stopJob()
    {
        log.info("Kimios Repository Cleaner - Closing ...");
        try {
            this.stop();
            thrc.join();
        } catch (Exception e) {

        }
        log.info("Kimios Repository Cleaner - Closed");
    }
}

