package trabalho.ces.trabalho.ces.backend.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component("mapperBase")
public class MapperBase {

    @Autowired
    MapperRegister mapperRegister;

    public <S, D> D mapTo(S source, Class<D> dest) {
        return mapperRegister.mapTo(source, dest);
    }

    public <S, D> List<D> toList(List<S> source, Type dest) {
        return mapperRegister.toList(source, dest);
    }

    public <S, D> Page<D> toPage(Page<S> source, Type dest) {
        List<D> list = mapperRegister.toList(source.getContent(), dest);
        return new PageImpl<>(list, source.getPageable(), source.getTotalElements());
    }

}