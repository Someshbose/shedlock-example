CREATE TABLE `shedlock` (
    `id` INTEGER PRIMARY KEY,
  `name` VARCHAR(64) ,
  `lock_until` TIMESTAMP(3) NULL,
  `locked_at` TIMESTAMP(3) NULL,
  `locked_by` VARCHAR(255),
)
