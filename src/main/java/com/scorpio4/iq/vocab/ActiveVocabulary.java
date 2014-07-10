package com.scorpio4.iq.vocab;

import com.scorpio4.runtime.Bootable;

/**
 * scorpio4-oss (c) 2014
 * Module: com.scorpio4.iq
 * User  : lee
 * Date  : 7/07/2014
 * Time  : 8:34 PM
 */
public interface ActiveVocabulary extends Bootable {

	public void start() throws Exception;
	public void stop() throws Exception;
	public void trigger(String resource);

}
