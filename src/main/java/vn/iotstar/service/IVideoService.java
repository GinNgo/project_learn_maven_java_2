package vn.iotstar.service;

import java.util.List;

import vn.iotstar.dao.IVideoDao;
import vn.iotstar.dao.impl.VideoDaoImpl;

import vn.iotstar.entity.Video;

public interface IVideoService {

	Long count();

	List<Video> findAll(int page, int pagesize);

	List<Video> findByVideoname(String videoname);

	List<Video> findAll();

	Video findById(String videoid);

	void delete(String videoid) throws Exception;

	void update(Video video);

	void insert(Video video);
	
	IVideoDao videoDao = new VideoDaoImpl();

}
