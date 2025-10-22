package vn.iotstar.dao.impl;

import java.util.List;

import vn.iotstar.dao.IVideoDao;
import vn.iotstar.entity.Video;

public class VideoDaoImpl extends AbstractEntityDao<Video> implements IVideoDao  {



public VideoDaoImpl() {

super(Video.class);


}

@Override
public List<Video> findByVideoname(String videoname) {
	// TODO Auto-generated method stub
	return null;
}



}