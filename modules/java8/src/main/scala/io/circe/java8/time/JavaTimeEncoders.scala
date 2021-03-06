package io.circe.java8.time

import io.circe.{ Encoder, Json }
import java.time.{
  Duration,
  Instant,
  LocalDate,
  LocalDateTime,
  LocalTime,
  OffsetDateTime,
  OffsetTime,
  Period,
  YearMonth,
  ZonedDateTime,
  ZoneId
}
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.{
  ISO_LOCAL_DATE,
  ISO_LOCAL_DATE_TIME,
  ISO_LOCAL_TIME,
  ISO_OFFSET_DATE_TIME,
  ISO_OFFSET_TIME,
  ISO_ZONED_DATE_TIME
}
import java.time.temporal.TemporalAccessor

private[time] abstract class JavaTimeEncoder[A <: TemporalAccessor] extends Encoder[A] {
  protected def format: DateTimeFormatter

  final def apply(a: A): Json = Json.fromString(format.format(a))
}

private[time] trait JavaTimeEncoders {
  /**
   * @group Time
   */
  implicit final val encodeDuration: Encoder[Duration] = Encoder.instance(duration =>
    Json.fromString(duration.toString)
  )

  /**
   * @group Time
   */
  implicit final val encodeInstant: Encoder[Instant] = Encoder.instance(time =>
    Json.fromString(time.toString)
  )

  /**
   * @group Time
   */
  implicit final val encodePeriod: Encoder[Period] = Encoder.instance(period =>
    Json.fromString(period.toString)
  )

  /**
   * @group Time
   */
  implicit final val encodeZoneId: Encoder[ZoneId] = Encoder.instance(zoneId =>
    Json.fromString(zoneId.getId)
  )

  /**
   * @group Time
   */
  final def encodeLocalDateWithFormatter(formatter: DateTimeFormatter): Encoder[LocalDate] =
    new JavaTimeEncoder[LocalDate] {
      protected final def format: DateTimeFormatter = formatter
    }

  /**
   * @group Time
   */
  final def encodeLocalTimeWithFormatter(formatter: DateTimeFormatter): Encoder[LocalTime] =
    new JavaTimeEncoder[LocalTime] {
      protected final def format: DateTimeFormatter = formatter
    }

  /**
   * @group Time
   */
  final def encodeLocalDateTimeWithFormatter(formatter: DateTimeFormatter): Encoder[LocalDateTime] =
    new JavaTimeEncoder[LocalDateTime] {
      protected final def format: DateTimeFormatter = formatter
    }

  /**
   * @group Time
   */
  final def encodeMonthDayWithFormatter(formatter: DateTimeFormatter): Encoder[MonthDay] =
    new JavaTimeEncoder[MonthDay] {
      protected final def format: DateTimeFormatter = formatter
    }

  /**
   * @group Time
   */
  final def encodeOffsetTimeWithFormatter(formatter: DateTimeFormatter): Encoder[OffsetTime] =
    new JavaTimeEncoder[OffsetTime] {
      protected final def format: DateTimeFormatter = formatter
    }

  /**
   * @group Time
   */
  final def encodeOffsetDateTimeWithFormatter(formatter: DateTimeFormatter): Encoder[OffsetDateTime] =
    new JavaTimeEncoder[OffsetDateTime] {
      protected final def format: DateTimeFormatter = formatter
    }

  /**
    * @group Time
    */
  final def encodeYearWithFormatter(formatter: DateTimeFormatter): Encoder[Year] =
    new JavaTimeEncoder[Year] {
      protected final def format: DateTimeFormatter = formatter
    }

  /**
    * @group Time
    */
  final def encodeYearMonthWithFormatter(formatter: DateTimeFormatter): Encoder[YearMonth] =
    new JavaTimeEncoder[YearMonth] {
      protected final def format: DateTimeFormatter = formatter
    }

  /**
   * @group Time
   */
  final def encodeZonedDateTimeWithFormatter(formatter: DateTimeFormatter): Encoder[ZonedDateTime] =
    new JavaTimeEncoder[ZonedDateTime] {
      protected final def format: DateTimeFormatter = formatter
    }

  /**
   * @group Time
   */
  final def encodeZoneOffsetWithFormatter(formatter: DateTimeFormatter): Encoder[ZoneOffset] =
    new JavaTimeEncoder[ZoneOffset] {
      protected final def format: DateTimeFormatter = formatter
    }

  /**
   * @group Time
   */
  implicit final val encodeLocalDate: Encoder[LocalDate] =
    new JavaTimeEncoder[LocalDate] {
      protected final def format: DateTimeFormatter = ISO_LOCAL_DATE
    }

  /**
   * @group Time
   */
  implicit final val encodeLocalTime: Encoder[LocalTime] =
    new JavaTimeEncoder[LocalTime] {
      protected final def format: DateTimeFormatter = ISO_LOCAL_TIME
    }

  /**
   * @group Time
   */
  implicit final val encodeLocalDateTime: Encoder[LocalDateTime] =
    new JavaTimeEncoder[LocalDateTime] {
      protected final def format: DateTimeFormatter = ISO_LOCAL_DATE_TIME
    }

  /**
    * @group Time
    */
  implicit final val encodeMonthDay: Encoder[MonthDay] = Encoder.instance(monthDay =>
    Json.fromString(monthDay.toString)
  )

  /**
   * @group Time
   */
  implicit final val encodeOffsetTime: Encoder[OffsetTime] =
    new JavaTimeEncoder[OffsetTime] {
      protected final def format: DateTimeFormatter = ISO_OFFSET_TIME
    }

  /**
   * @group Time
   */
  implicit final val encodeOffsetDateTime: Encoder[OffsetDateTime] =
    new JavaTimeEncoder[OffsetDateTime] {
      protected final def format: DateTimeFormatter = ISO_OFFSET_DATE_TIME
    }

  /**
    * @group Time
    */
  implicit final val encodeYear: Encoder[Year] = Encoder.instance(year =>
    Json.fromString(year.toString)
  )

  /**
    * @group Time
    */
  implicit final val encodeYearMonth: Encoder[YearMonth] = Encoder.instance(yearMonth =>
    Json.fromString(yearMonth.toString)
  )

  /**
   * @group Time
   */
  implicit final val encodeZonedDateTime: Encoder[ZonedDateTime] =
    new JavaTimeEncoder[ZonedDateTime] {
      protected final def format: DateTimeFormatter = ISO_ZONED_DATE_TIME
    }

  /**
    * @group Time
    */
  implicit final val encodeZoneOffset: Encoder[ZoneOffset] = Encoder.instance(zoneOffset =>
    Json.fromString(zoneOffset.toString)
  )
}
