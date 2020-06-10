package az.itstep.as.mapper;

/**
 *
 * @param <D> stands for DTO
 * @param <E> stands for Entity
 */
public interface BaseMapper<D, E> {
    E toEntity(D dto);
    D toDTO(E entity);
}
