package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.entity.Video;

public interface IVideoDao extends IEntityDao<Video>{

	List<Video> findByVideoname(String videoname);

}
