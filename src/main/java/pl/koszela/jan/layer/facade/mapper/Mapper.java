package pl.koszela.jan.layer.facade.mapper;


import java.util.List;

/**
 * Created on 15.08.2017.
 *
 * @author Jan Koszela
 */
public interface Mapper<FROM, TO> {

  TO map(FROM fromObject);

  List<TO> map(List<FROM> fromList);
}
