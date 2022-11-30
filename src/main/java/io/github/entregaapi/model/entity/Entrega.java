package io.github.entregaapi.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import io.github.entregaapi.model.enums.StatusEntrega;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="entrega")
public class Entrega {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="taxa")
	private BigDecimal taxa;
	
	@Column(name="data_pedido")
	@Convert(converter=Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate dataPedido;
	
	@Column(name="data_finalizacao")
	@Convert(converter=Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate dataFinalizacao;
	
	@Column(name="status_entrega")
	@Enumerated(EnumType.STRING)
	private StatusEntrega statusEntrega;
	
	@OneToOne
	private Destinatario destinatario;
	
	@OneToOne
	private Cliente cliente;
}
