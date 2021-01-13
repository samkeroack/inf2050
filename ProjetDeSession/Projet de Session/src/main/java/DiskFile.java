/*
 * Copyright 2015 Jacques Berger.
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

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Permet de lire et d'écrire dans un fichier texte à l'aide de string
 */
public class DiskFile {
    /**
     * Lit un fichier texte
     *
     * @param filePath le chemin du fichier
     * @return le fichier en format string
     * @throws IOException si le fichier est inaccessible
     */
    public static String loadFileIntoString(String filePath) throws IOException {
        return IOUtils.toString(new FileInputStream(filePath), "UTF-8");
    }

    /**
     * Enregistre un dans un fichier texte
     *
     * @param filePath chemin de sortie du fichier
     * @param content  le contenu à enregistrer
     * @throws IOException si le fichier est inaccessible
     */
    public static void saveStringIntoFile(String filePath, String content) throws IOException {
        File f = new File(filePath);
        FileUtils.writeStringToFile(f, content, "UTF-8");
    }

}
