package pl.pawel.linkshell.layer.facade.mapper;


import java.util.List;

/**
 * Created on 15.08.2017.
 *
 */
// F - From
// T - To
public interface Mapper<F, T> {

  T map(F fObject);

  List<T> map(List<F> fList);
}
