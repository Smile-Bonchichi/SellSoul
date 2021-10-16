package kg.itAcademy.SellSoul.entity;

import kg.itAcademy.SellSoul.entity.BaseEntity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "auctions")
@Entity
public class Auction extends BaseEntity {
}