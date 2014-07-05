package com.scorpio4.assets;

import com.scorpio4.util.Identifiable;
import com.scorpio4.vocab.COMMON;

/**
 * Scorpio4 (c) 2014
 * Module: com.scorpio4.assets
 * User  : lee
 * Date  : 17/06/2014
 * Time  : 8:50 PM
 */
public class Asset implements Identifiable {
	String identity = null;
    Object content = null;
    String mimeType = null;

	public Asset(String identity, Object content, String mimeType) {
		this.identity=identity;
		this.content=content;
		this.mimeType=mimeType;
	}

    public Asset(Object content, String mimeType) {
        this.content=content;
        this.mimeType=mimeType;
    }

    public Asset(String content) {
        this.content=content;
        this.mimeType= COMMON.MIME_PLAIN;
    }

    public Object getContent() {
        return content;
    }

    public String getMimeType() {
        return mimeType;
    }

	public String getContentType() {
		if (getMimeType().startsWith(COMMON.MIME_TYPE)) {
			return getMimeType().substring(COMMON.MIME_TYPE.length());
		}
		return mimeType;
	}

	public String toString() {
        return content.toString();
    }

	public void setMimeType(String mimeType) {
		this.mimeType=mimeType;
	}

	@Override
	public String getIdentity() {
		return identity;
	}
}


