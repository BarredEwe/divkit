// Generated code. Do not modify.

import 'package:equatable/equatable.dart';

import 'package:divkit/src/utils/parsing_utils.dart';

class IntegerVariable with EquatableMixin {
  const IntegerVariable({
    required this.name,
    required this.value,
  });

  static const type = "integer";

  final String name;

  final int value;

  @override
  List<Object?> get props => [
        name,
        value,
      ];

  IntegerVariable copyWith({
    String? name,
    int? value,
  }) =>
      IntegerVariable(
        name: name ?? this.name,
        value: value ?? this.value,
      );

  static IntegerVariable? fromJson(Map<String, dynamic>? json) {
    if (json == null) {
      return null;
    }
    try {
      return IntegerVariable(
        name: safeParseStr(
          json['name']?.toString(),
        )!,
        value: safeParseInt(
          json['value'],
        )!,
      );
    } catch (e) {
      return null;
    }
  }
}
