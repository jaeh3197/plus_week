package com.example.demo.repository;

import com.example.demo.entity.QReservation;
import com.example.demo.entity.Reservation;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReservationCustomRepositoryImpl implements ReservationCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    QReservation reservation = QReservation.reservation;

    // 동적 쿼리 사용
    @Override
    public List<Reservation> findByUserIdOrItemId(Long userId, Long itemId) {

        return jpaQueryFactory
                .selectFrom(reservation)
                .where(userIdEq(userId), itemIdEq(itemId))
                .fetch();
    }

    //BooleanExpression 사용
    private BooleanExpression userIdEq(Long userId) {
        return userId != null ? reservation.user.id.eq(userId) : null;
    }

    private BooleanExpression itemIdEq(Long itemId) {
        return itemId != null ? reservation.item.id.eq(itemId) : null;
    }
}
