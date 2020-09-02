package me.ele.lancet.plugin.internal.context;

import com.android.build.api.transform.QualifiedContent;
import com.android.build.api.transform.Status;

import java.io.IOException;

/**
 * The Fetcher to fetch each class in QualifiedContent
 */
public interface ClassFetcher {

    /**
     * begin unzip a QualifiedContent.
     * @param content the Jar or Dir QualifiedContent.
     * @return whether the Fetcher can accept this QualifiedContent.
     * @throws IOException  IOException
     */
    boolean onStart(QualifiedContent content) throws IOException;

    /**
     * fetch each class in QualifiedContent. each invoke will in one thread.
     * @param content content
     * @param status status
     * @param relativePath relativePath
     * @param bytes bytes
     * @throws IOException IOException
     */
    void onClassFetch(QualifiedContent content, Status status, String relativePath, byte[] bytes) throws IOException;

    /**
     * has finished fetch class in this QualifiedContent
     * @param content content
     * @throws IOException IOException
     */
    void onComplete(QualifiedContent content) throws IOException;
}